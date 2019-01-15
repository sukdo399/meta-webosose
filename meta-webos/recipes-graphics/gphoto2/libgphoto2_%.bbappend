# Copyright (c) 2017-2019 LG Electronics, Inc.

EXTENDPRAUTO_append = "webos2"

PACKAGES =+ "${PN}-print-camera-list"
FILES_${PN}-print-camera-list = "${libdir}/*/print-camera-list"

PACKAGES =+ "${PN}-gpl"
FILES_${PN}-gpl = "${libdir}/libgphoto2*/*/pentax.so"
