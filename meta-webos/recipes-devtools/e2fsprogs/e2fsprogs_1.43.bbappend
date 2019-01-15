# Copyright (c) 2012-2019 LG Electronics, Inc.

EXTENDPRAUTO_append = "webos12"
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://e2fsck.conf"

do_install_append() {
    install -d ${D}${sysconfdir}
    install -v -m 0644 ${WORKDIR}/e2fsck.conf ${D}${sysconfdir}/
}
