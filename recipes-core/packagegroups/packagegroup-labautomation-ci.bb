SUMMARY = "CI runners and agents for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    gitlab-runner \
    jenkins-agent \
"

# Add github-runner to IMAGE_INSTALL when needed
