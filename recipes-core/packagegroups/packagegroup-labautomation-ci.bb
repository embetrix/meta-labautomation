SUMMARY = "CI runners and agents for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    github-runner \
    gitlab-runner \
    jenkins-agent \
"
