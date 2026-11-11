// SPDX-License-Identifier: MIT
// Copyright 2026 Embetrix Embedded Systems Solutions <ayoub.zaki@embetrix.com>
// Jenkinsfile for building the lab automation image for Raspberry Pi secure
pipeline {
    agent { dockerfile true }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'wrynose', selectedValue: 'DEFAULT', name: 'BRANCH', type: 'PT_BRANCH', description: 'branch to build'
        choice choices: ['raspberrypi5', 'raspberrypi4-64' ], description: 'select machine', name: 'MACHINE'
        choice choices: ['dev', 'prod'], description: 'select security profile', name: 'SECURITY_PROFILE'
        choice choices: ['no', 'yes'], description: 'clean workspace', name: 'CLEAN'
    }
    environment {
        KAS_CLONE_DEPTH = "1"
        KAS_CONFIG = 'kas/kas-labautomation-rpi-secure.yml'
        KAS_MACHINE = "${params.MACHINE}"
        KAS_TARGET = 'labautomation-image labautomation-image-update'
        SECURITY_PROFILE = "${params.SECURITY_PROFILE}"
    }

    stages {

        stage('Clean') {
            when {
                expression { params.CLEAN == 'yes' }
            }
            steps {
               sh "git clean -fdx"
            }
        }

        stage('Setup') {
            steps {
                // Fetch the secure layer before using its signing-key helper.
                sh 'kas checkout --force-checkout --update "$KAS_CONFIG"'
                withCredentials([file(credentialsId: 'fd6cfa4d-679d-4d04-9e6a-74073de43385', variable: 'KEYS_TARBALL')]) {
                    sh 'tar xzf "$KEYS_TARBALL" -C "$WORKSPACE"'
                }
                sh 'layers/meta-raspberrypi-secure/tools/genkey-helper.sh "$WORKSPACE/rpi-secure-keys" "$WORKSPACE/kas/kas-signing-keys.yml"'
            }
        }

        stage('Build-Image') {
            steps {
                sh 'kas build "$KAS_CONFIG:kas/kas-signing-keys.yml"'
                archiveArtifacts artifacts: [
                                             "build/tmp/deploy/images/${params.MACHINE}/labautomation-image-${params.MACHINE}.rootfs-${params.SECURITY_PROFILE}_*.*",
                                             "build/tmp/deploy/images/${params.MACHINE}/labautomation-image-update-${params.MACHINE}.rootfs-${params.SECURITY_PROFILE}_*.swu"
                                             ].join(','),
                                             excludes: "**/*.ext3,**/*.ext4,**/*.rootfs.wic",
                                             followSymlinks: false,
                                             fingerprint: true,
                                             onlyIfSuccessful: true
            }
        }

    }
}
