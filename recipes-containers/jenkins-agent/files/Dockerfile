# SPDX-License-Identifier: MIT
# Copyright 2026 Embetrix Embedded Systems Solutions <ayoub.zaki@embetrix.com>

ARG BASE_IMAGE=jenkins/inbound-agent:jdk21
FROM ${BASE_IMAGE}

USER root
RUN apt-get update \
    && apt-get install -y --no-install-recommends \
        ca-certificates libudev1 openssh-client python3 python3-venv rsync inetutils-telnet \
    && python3 -m venv /opt/labgrid \
    && /opt/labgrid/bin/pip install --no-cache-dir 'labgrid==26.0' \
    && install -d -m 0700 -o jenkins -g jenkins /home/jenkins/.ssh \
    && rm -rf /var/lib/apt/lists/*

ENV PATH="/opt/labgrid/bin:${PATH}"
USER jenkins
WORKDIR /home/jenkins/agent
