# Copyright (c) 2012-2018 LG Electronics, Inc.

DESCRIPTION = "meta-webos components used in webOS OSE"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

# You don't need to change this value when you're changing just RDEPENDS_${PN} variable.
PR = "r28"

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup
inherit webos_machine_impl_dep

VIRTUAL-RUNTIME_appinstalld ?= "appinstalld2"
VIRTUAL-RUNTIME_event-monitor-network ?= "event-monitor-network"
VIRTUAL-RUNTIME_memorymanager ?= "com.webos.service.memorymanager"
VIRTUAL-RUNTIME_webappmanager ?= ""
VIRTUAL-RUNTIME_initscripts ?= "initscripts"
VIRTUAL-RUNTIME_librdx ?= "rdxd"
VIRTUAL-RUNTIME_surface-manager ?= "luna-surfacemanager-base"
VIRTUAL-RUNTIME_webos-ime ?= ""
VIRTUAL-RUNTIME_novacomd ?= "novacomd"
VIRTUAL-RUNTIME_nyx_modules_providers ??= "\
    nyx-modules \
    nyx-modules-qemux86 \
"
VIRTUAL-RUNTIME_com.webos.app.browser ?= "com.webos.app.browser"

# We're not using VIRTUAL-RUNTIME because VIRTUAL-RUNTIME is usually used for only
# one item and changing that in <distro>-preferred-providers.inc would require
# .bbappend in meta-<distro> to do PR/PRINC/PR_append bump anyway so it's easier
# to change this variable in .bbappend together with bump.
#
WEBOS_PACKAGESET_TESTAPPS = " \
    bareapp \
    com.webos.app.test.enact \
    com.webos.app.test.webosose \
    com.webos.app.test.youtube \
"

# Fonts used by the browser
VIRTUAL-RUNTIME_browser_fonts ?= "webos-fonts"

VIRTUAL-RUNTIME_settingsapp ?= "com.webos.app.settings"
VIRTUAL-RUNTIME_settingsapp_armv4 = ""
VIRTUAL-RUNTIME_settingsapp_armv5 = ""

VIRTUAL-RUNTIME_umediaserver ?= "umediaserver"
VIRTUAL-RUNTIME_umediaserver_armv4 = ""
VIRTUAL-RUNTIME_umediaserver_armv5 = ""

VIRTUAL-RUNTIME_iotivity-node ?= "iotivity-node"
VIRTUAL-RUNTIME_iotivity-node_armv4 = ""
VIRTUAL-RUNTIME_iotivity-node_armv5 = ""

# This packageset controls which time zone packages should be included in webOS.
# Since any application that uses localtime will indirectly depend on presence of
# time zone data, we pull in those packages as a top-level dependency. By
# assigning the list to its own variable, we have the option to only include a
# subset should there be a device that will only be used within some region.
WEBOS_PACKAGESET_TZDATA ?= " \
    tzdata \
    tzdata-africa \
    tzdata-americas \
    tzdata-antarctica \
    tzdata-arctic \
    tzdata-asia \
    tzdata-atlantic \
    tzdata-australia \
    tzdata-europe \
    tzdata-misc \
    tzdata-pacific \
    tzdata-posix \
    tzdata-right \
"

PYTHON2 = " \
    python \
    python-async \
    python-autobahn \
    python-backports-abc \
    python-backports-ssl \
    python-bcrypt \
    python-behave \
    python-bitarray \
    python-blinker \
    python-certifi \
    python-cffi \
    python-chardet \
    python-cheetah \
    python-click \
    python-cloudeebus \
    python-cmd2 \
    python-cpuset \
    python-cryptography \
    python-cryptography-vectors \
    python-cython \
    python-daemonize \
    python-dateutil \
    python-dbus \
    python-dbusmock \
    python-decorator \
    python-django \
    python-django-south \
    python-dominate \
    python-enum34 \
    python-epydoc \
    python-feedformatter \
    python-feedparser \
    python-flask \
    python-flask-bcrypt \
    python-flask-bootstrap \
    python-flask-login \
    python-flask-navigation \
    python-flask-pymongo \
    python-flask-sqlalchemy \
    python-flask-wtf \
    python-functools32 \
    python-futures \
    python-gdata \
    python-gevent \
    python-git \
    python-gitdb \
    python-greenlet \
    python-html5lib \
    python-idna \
    python-imaging \
    python-ipaddress \
    python-iso8601 \
    python-itsdangerous \
    python-jinja2 \
    python-jsonpatch \
    python-jsonpointer \
    python-jsonschema \
    python-ldap \
    python-lxml \
    python-m2crypto \
    python-mako \
    python-markupsafe \
    python-mccabe \
    python-mock \
    python-monotonic \
    python-msgpack \
    python-ndg-httpsclient \
    python-netaddr \
    python-nose \
    python-numeric \
    python-numpy \
    python-paho-mqtt \
    python-pam \
    python-parse \
    python-parse-type \
    python-passlib \
    python-paste \
    python-pbr \
    python-pep8 \
    python-pexpect \
    python-pip \
    python-pretend \
    python-prettytable \
    python-progress \
    python-prompt-toolkit \
    python-psutil \
    python-ptyprocess \
    python-py \
    python-pyalsaaudio \
    python-pyasn1 \
    python-pybind11 \
    python-pycparser \
    python-pycurl \
    python-pyephem \
    python-pyflakes \
    python-pygobject \
    python-pygpgme \
    python-pyhamcrest \
    python-pyinotify \
    python-pylint \
    python-pymisp \
    python-pymongo \
    python-pyopenssl \
    python-pyparsing \
    python-pyparted \
    python-pyrex \
    python-pyro4 \
    python-pyroute2 \
    python-pyserial \
    python-pysocks \
    python-pytest \
    python-pytest-runner \
    python-pytz \
    python-pyudev \
    python-pyusb \
    python-pyyaml \
    python-pyzmq \
    python-redis \
    python-requests \
    python-rfc3987 \
    python-scons \
    python-setuptools \
    python-setuptools-scm \
    python-simplejson \
    python-singledispatch \
    python-six \
    python-slip-dbus \
    python-smbus \
    python-smmap \
    python-snakefood \
    python-sparts \
    python-sqlalchemy \
    python-strict-rfc3339 \
    python-thrift \
    python-tornado \
    python-tornado-redis \
    python-twisted \
    python-txws \
    python-ujson \
    python-unidiff \
    python-urllib3 \
    python-vcversioner \
    python-visitor \
    python-vobject \
    python-wcwidth \
    python-webcolors \
    python-webdav \
    python-werkzeug \
    python-whoosh \
    python-wtforms \
    python-xlrd \
    python-yappi \
    python-zopeinterface \
"

PYTHON3 = " \
    python3 \
    python3-async \
    python3-certifi \
    python3-cffi \
    python3-click \
    python3-cython \
    python3-dateutil \
    python3-dbus \
    python3-decorator \
    python3-docutils \
    python3-feedformatter \
    python3-git \
    python3-gitdb \
    python3-idna \
    python3-iso8601 \
    python3-itsdangerous \
    python3-jinja2 \
    python3-lxml \
    python3-mako \
    python3-markupsafe \
    python3-passlib \
    python3-pip \
    python3-pretend \
    python3-progress \
    python3-prompt-toolkit \
    python3-py \
    python3-pyasn1 \
    python3-pybind11 \
    python3-pycairo \
    python3-pycparser \
    python3-pygobject \
    python3-pyinotify \
    python3-pymongo \
    python3-pyserial \
    python3-pysocks \
    python3-redis \
    python3-rfc3987 \
    python3-setuptools \
    python3-six \
    python3-smmap \
    python3-strict-rfc3339 \
    python3-tornado \
    python3-vcversioner \
    python3-wcwidth \
    python3-webcolors \
    python3-werkzeug \
    python3-whoosh \
"

RDEPENDS_${PN} = " \
    activitymanager \
    audiod \
    bootd \
    configd \
    configurator \
    com.palm.service.devmode \
    event-monitor \
    filecache \
    fontconfig-utils \
    ilib-qml-plugin \
    ilib-webapp \
    luna-downloadmgr \
    luna-init \
    luna-sysservice \
    mojoservicelauncher \
    nodejs-module-webos-service \
    notificationmgr \
    pacrunner \
    pmklogd \
    pmlogctl \
    pmlogdaemon \
    ${PYTHON2} \
    ${PYTHON3} \
    sam \
    settingsservice \
    sleepd \
    webos-connman-adapter \
    webos-fontconfig-files \
    ${VIRTUAL-RUNTIME_appinstalld} \
    ${VIRTUAL-RUNTIME_browser_fonts} \
    ${VIRTUAL-RUNTIME_com.webos.app.browser} \
    ${VIRTUAL-RUNTIME_event-monitor-network} \
    ${VIRTUAL-RUNTIME_initscripts} \
    ${VIRTUAL-RUNTIME_librdx} \
    ${VIRTUAL-RUNTIME_memorymanager} \
    ${VIRTUAL-RUNTIME_novacomd} \
    ${VIRTUAL-RUNTIME_nyx_modules_providers} \
    ${VIRTUAL-RUNTIME_settingsapp} \
    ${VIRTUAL-RUNTIME_surface-manager} \
    ${VIRTUAL-RUNTIME_umediaserver} \
    ${VIRTUAL-RUNTIME_webappmanager} \
    ${VIRTUAL-RUNTIME_webos-ime} \
    ${WEBOS_PACKAGESET_TESTAPPS} \
    ${WEBOS_PACKAGESET_TZDATA} \
    ${WEBOS_FOSS_MISSING_FROM_RDEPENDS} \
"

RDEPENDS_${PN}_append_hardware = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', '${VIRTUAL-RUNTIME_bluetooth_service}', '', d)} \
"

RDEPENDS_${PN}_append_webos = " node-inspector ${VIRTUAL-RUNTIME_iotivity-node}"

# XXX These FOSS components must be explicitly added because they are missing
# from the RDEPENDS lists of the components that expect them to be present at
# runtime (or perhaps some are in fact top-level components and some others
# aren't actually needed).
WEBOS_FOSS_MISSING_FROM_RDEPENDS = " \
    bzip2 \
    curl \
    e2fsprogs \
    hunspell \
    icu \
    iproute2 \
    lsb \
    makedevs \
    ncurses \
    openssl \
    procps \
    psmisc \
    sqlite3 \
    ${@'systemd-analyze' if '${VIRTUAL-RUNTIME_init_manager}' == 'systemd' else 'sysvinit-pidof'} \
"

# These packages that are installed in the qemux86 image only.
RDEPENDS_${PN}_append_qemux86 = " \
    dhcp-client \
"

RDEPENDS_${PN} += "${MACHINE_EXTRA_RDEPENDS}"
RRECOMMENDS_${PN} += "${MACHINE_EXTRA_RRECOMMENDS}"

# Unused meta-webos components:
# - libtinyxml
