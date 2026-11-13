# Keep labgrid state, settings and uploads on the data partition
VOLATILE_BINDS:append = "\
${localstatedir}/data${sysconfdir}/labgrid-dashboard ${sysconfdir}/labgrid-dashboard\n\
${localstatedir}/data${localstatedir}/lib/private/labgrid-coordinator ${localstatedir}/lib/private/labgrid-coordinator\n\
${localstatedir}/data${localstatedir}/cache/labgrid ${localstatedir}/cache/labgrid\n\
${localstatedir}/data${sysconfdir}/labgrid ${sysconfdir}/labgrid\n\
"

LABAUTOMATION_BIND_DIRS:append = " lib/private/labgrid-coordinator cache/labgrid"
