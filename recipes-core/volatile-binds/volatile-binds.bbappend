# Keep container storage on the persistent data partition.
VOLATILE_BINDS:append = "\
${localstatedir}/data${localstatedir}/lib/docker ${localstatedir}/lib/docker\n\
${localstatedir}/data${localstatedir}/lib/containerd ${localstatedir}/lib/containerd\n\
"

do_compile:append() {
    for name in docker containerd; do
        # Mount after the parent /var/lib bind. Its writable tmpfs must not
        # cause the persistent child binds to be skipped.
        sed -i \
            -e '/^ConditionPathIsReadWrite=!/d' \
            -e 's/^Environment=MOUNT_COPYBIND_AVOID_OVERLAYFS=.*/Environment=MOUNT_COPYBIND_AVOID_OVERLAYFS=1/' \
            -e '/^\[Unit\]/a Requires=var-volatile-lib.service\nAfter=var-volatile-lib.service' \
            var-data-var-lib-$name.service
    done
}
