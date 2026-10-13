SUMMARY = "GitLab CI job runner"
HOMEPAGE = "https://docs.gitlab.com/runner/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://gitlab-runner-${PV}-LICENSE;md5=6fbcd88d72be783faee090dc8f227594"

# Package the official standalone binaries, pinned to a release and checksum.
GITLAB_RUNNER_ARCH:x86-64 = "amd64"
GITLAB_RUNNER_ARCH:aarch64 = "arm64"
GITLAB_RUNNER_ARCH:arm = "arm"

GITLAB_RUNNER_SHA256:x86-64 = "5a159b36c5ff54fda9248e00bb0cdfb62c1112ab3741f5282c04a41e94da1306"
GITLAB_RUNNER_SHA256:aarch64 = "9763a63f7bc2319119f80de41d1d414465b5268d072bcd55266020b989e93ee9"
GITLAB_RUNNER_SHA256:arm = "e075f4804df9537192c91c9181e16bd9a8c36b45ea093eb2fda23e03d4c01518"

SRC_URI = " \
    https://s3.dualstack.us-east-1.amazonaws.com/gitlab-runner-downloads/v${PV}/binaries/gitlab-runner-linux-${GITLAB_RUNNER_ARCH};name=runner;downloadfilename=gitlab-runner-${PV}-${GITLAB_RUNNER_ARCH} \
    https://gitlab.com/gitlab-org/gitlab-runner/-/raw/v${PV}/LICENSE;name=license;downloadfilename=gitlab-runner-${PV}-LICENSE \
    file://gitlab-runner.service \
"
SRC_URI[runner.sha256sum] = "${GITLAB_RUNNER_SHA256}"
SRC_URI[license.sha256sum] = "aa6e97cbe04ad41e1c081ec01740e9ed3c2453af66a082db1e6fc73b2cb96c6a"

S = "${UNPACKDIR}"
COMPATIBLE_HOST = "(x86_64|aarch64|arm).*-linux"

inherit systemd useradd

do_configure[noexec] = "1"
do_compile[noexec] = "1"

# Keep the upstream Go binary intact.
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "--system --user-group --home-dir ${localstatedir}/lib/gitlab-runner --no-create-home --shell /bin/bash gitlab-runner"

SYSTEMD_SERVICE:${PN} = "gitlab-runner.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

RDEPENDS:${PN} = "bash ca-certificates git"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${UNPACKDIR}/gitlab-runner-${PV}-${GITLAB_RUNNER_ARCH} ${D}${bindir}/gitlab-runner

    install -d -m 0700 ${D}${sysconfdir}/gitlab-runner
    install -d -m 0750 ${D}${localstatedir}/lib/gitlab-runner
    chown gitlab-runner:gitlab-runner ${D}${localstatedir}/lib/gitlab-runner

    install -d ${D}${systemd_system_unitdir}
    sed -e 's|@BINDIR@|${bindir}|g' \
        -e 's|@SYSCONFDIR@|${sysconfdir}|g' \
        -e 's|@LOCALSTATEDIR@|${localstatedir}|g' \
        ${UNPACKDIR}/gitlab-runner.service > ${D}${systemd_system_unitdir}/gitlab-runner.service
}

FILES:${PN} += "${sysconfdir}/gitlab-runner ${localstatedir}/lib/gitlab-runner"
