# Keep container storage, runner settings and SSH keys on the data partition
VOLATILE_BINDS:append = "\
${localstatedir}/data${localstatedir}/lib/docker ${localstatedir}/lib/docker\n\
${localstatedir}/data${localstatedir}/lib/containerd ${localstatedir}/lib/containerd\n\
${localstatedir}/data${localstatedir}/lib/github-runner /opt/github-runner\n\
${localstatedir}/data${localstatedir}/lib/gitlab-runner ${localstatedir}/lib/gitlab-runner\n\
${localstatedir}/data${sysconfdir}/gitlab-runner ${sysconfdir}/gitlab-runner\n\
${localstatedir}/data${sysconfdir}/jenkins-agent ${sysconfdir}/jenkins-agent\n\
${localstatedir}/data/home/labautomation /home/labautomation\n\
"

LABAUTOMATION_BIND_DIRS = "lib/docker lib/containerd lib/github-runner lib/gitlab-runner"

do_compile:append() {
    for path in ${LABAUTOMATION_BIND_DIRS}; do
        parent=${path%%/*}
        name=$(echo "$path" | tr / -)

        # Use persistent storage even when the destination is already writable
        sed -i \
            -e '/^ConditionPathIsReadWrite=!/d' \
            -e 's/^Environment=MOUNT_COPYBIND_AVOID_OVERLAYFS=.*/Environment=MOUNT_COPYBIND_AVOID_OVERLAYFS=1/' \
            var-data-var-$name.service

        # The runner now mounts under /opt, outside the parent tmpfs binds
        if [ "$path" != lib/github-runner ]; then
            sed -i \
                -e "/^\[Unit\]/a Requires=var-volatile-$parent.service\nAfter=var-volatile-$parent.service" \
                var-data-var-$name.service
        fi
    done
}
