FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://labgrid-dashboard-location.conf"

# Run after all install appends, which may replace the default site.
do_install[postfuncs] += "labgrid_dashboard_install_proxy"
labgrid_dashboard_install_proxy() {
    install -m 0644 ${UNPACKDIR}/labgrid-dashboard-location.conf \
        ${D}${sysconfdir}/nginx/labgrid-dashboard-location.conf
    if ! grep -Fq 'include ${sysconfdir}/nginx/labgrid-dashboard-location.conf;' \
        ${D}${sysconfdir}/nginx/sites-available/default_server; then
        sed -i '/^[[:space:]]*listen[[:space:]]\+443[[:space:]]\+ssl[[:space:]]*;/a\    include ${sysconfdir}/nginx/labgrid-dashboard-location.conf;' \
            ${D}${sysconfdir}/nginx/sites-available/default_server
    fi
    grep -q '^[[:space:]]*include ${sysconfdir}/nginx/labgrid-dashboard-location.conf;' \
        ${D}${sysconfdir}/nginx/sites-available/default_server || \
        bbfatal "Dashboard requires an HTTPS default_server.site: provide one with listen 443 ssl and your TLS certificate configuration. HTTP fallback is disabled."
}

FILES:${PN} += "${sysconfdir}/nginx/labgrid-dashboard-location.conf"
CONFFILES:${PN} += "${sysconfdir}/nginx/labgrid-dashboard-location.conf"
