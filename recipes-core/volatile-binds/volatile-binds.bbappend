# Keep container storage, runner and labgrid state/configuration, uploads and SSH keys
# on the persistent data partition.
VOLATILE_BINDS:append = "\
${localstatedir}/data${localstatedir}/lib/docker ${localstatedir}/lib/docker\n\
${localstatedir}/data${localstatedir}/lib/containerd ${localstatedir}/lib/containerd\n\
${localstatedir}/data${localstatedir}/lib/github-runner ${localstatedir}/lib/github-runner\n\
${localstatedir}/data${localstatedir}/lib/gitlab-runner ${localstatedir}/lib/gitlab-runner\n\
${localstatedir}/data${sysconfdir}/gitlab-runner ${sysconfdir}/gitlab-runner\n\
${localstatedir}/data${sysconfdir}/jenkins-agent ${sysconfdir}/jenkins-agent\n\
${localstatedir}/data${sysconfdir}/labgrid-dashboard ${sysconfdir}/labgrid-dashboard\n\
${localstatedir}/data${localstatedir}/lib/private/labgrid-coordinator ${localstatedir}/lib/private/labgrid-coordinator\n\
${localstatedir}/data${localstatedir}/cache/labgrid ${localstatedir}/cache/labgrid\n\
${localstatedir}/data${sysconfdir}/labgrid ${sysconfdir}/labgrid\n\
${localstatedir}/data/home/labautomation /home/labautomation\n\
"

do_compile:append() {
    for path in lib/docker lib/containerd lib/github-runner lib/gitlab-runner lib/private/labgrid-coordinator cache/labgrid; do
        parent=${path%%/*}
        name=$(echo "$path" | tr / -)

        # Persistent children must follow the parent tmpfs bind, even when
        # that parent has already made their destination writable.
        sed -i \
            -e '/^ConditionPathIsReadWrite=!/d' \
            -e 's/^Environment=MOUNT_COPYBIND_AVOID_OVERLAYFS=.*/Environment=MOUNT_COPYBIND_AVOID_OVERLAYFS=1/' \
            -e "/^\[Unit\]/a Requires=var-volatile-$parent.service\nAfter=var-volatile-$parent.service" \
            var-data-var-$name.service
    done
}
