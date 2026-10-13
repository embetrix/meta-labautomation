SUMMARY = "GitHub Actions self-hosted runner"
HOMEPAGE = "https://github.com/actions/runner"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/github-runner-${PV}-LICENSE;md5=58195fc510663ad025b6f3a6c2013e51"

# Package the official runner with its bundled .NET and Node.js runtimes.
GITHUB_RUNNER_ARCH:x86-64 = "x64"
GITHUB_RUNNER_ARCH:aarch64 = "arm64"
GITHUB_RUNNER_SHA256:x86-64 = "af4b794c1bc41d73d40535e3fe092a39f9679cd8d965954c2aca25a05ca41d32"
GITHUB_RUNNER_SHA256:aarch64 = "628b4a7258487b80c1d3c221095a7ded349f5ae0175fd3dfab708d07428f041b"

SRC_URI = " \
    https://github.com/actions/runner/releases/download/v${PV}/actions-runner-linux-${GITHUB_RUNNER_ARCH}-${PV}.tar.gz;name=runner;subdir=github-runner \
    https://raw.githubusercontent.com/actions/runner/v${PV}/LICENSE;name=license;downloadfilename=github-runner-${PV}-LICENSE \
    file://github-runner.service \
"
SRC_URI[runner.sha256sum] = "${GITHUB_RUNNER_SHA256}"
SRC_URI[license.sha256sum] = "621a1e0b6163b9d63fe780b9d6f5a7f775a5781065024a1ebf8010726c44cec1"

S = "${UNPACKDIR}/github-runner"
COMPATIBLE_HOST = "(x86_64|aarch64).*-linux$"

inherit systemd useradd

do_configure[noexec] = "1"
do_compile[noexec] = "1"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "--system docker"
USERADD_PARAM:${PN} = "--system --user-group --groups docker --home-dir ${localstatedir}/lib/github-runner --no-create-home --shell /bin/bash github-runner"

SYSTEMD_SERVICE:${PN} = "github-runner.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

# Some .NET dependencies are loaded dynamically and need explicit dependencies.
# config.sh also checks for ldd and ldconfig before registration.
RDEPENDS:${PN} = " \
    bash \
    ca-certificates \
    git \
    icu \
    ldconfig \
    ldd \
    libgcc \
    libgssapi-krb5 \
    libstdc++ \
    libssl \
    zlib \
"

do_install() {
    # Registration, logs, jobs and upstream updates require a writable runner home.
    install -d -m 0750 ${D}${localstatedir}/lib/github-runner
    cp -R --no-preserve=ownership ${S}/. ${D}${localstatedir}/lib/github-runner/

    # The optional .NET LTTng provider requires liblttng-ust.so.0, while this
    # release supplies liblttng-ust.so.1. The runner works without this provider;
    # omit it rather than installing an incompatible tracing dependency.
    rm -f ${D}${localstatedir}/lib/github-runner/bin/libcoreclrtraceptprovider.so

    # Alpine Node.js runtimes require musl and cannot run on this glibc target.
    # JavaScript actions in Alpine job containers are therefore not supported.
    rm -rf ${D}${localstatedir}/lib/github-runner/externals/node*_alpine

    chown -R github-runner:github-runner ${D}${localstatedir}/lib/github-runner

    install -d ${D}${systemd_system_unitdir}
    sed -e 's|@LOCALSTATEDIR@|${localstatedir}|g' \
        ${UNPACKDIR}/github-runner.service > ${D}${systemd_system_unitdir}/github-runner.service
}

FILES:${PN} += "${localstatedir}/lib/github-runner"
