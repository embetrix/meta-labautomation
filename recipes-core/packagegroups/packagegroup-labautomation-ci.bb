SUMMARY = "CI runners and agents for lab automation"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    gitlab-runner \
    jenkins-agent \
"

# Github runner is huuuuge !! 
# disable it for now
# RDEPENDS:${PN} = " \
#     github-runner \
# "
