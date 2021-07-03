FILES_${PN}-dbg += "\
	${libdir}/enigma2/python/*.debug \
	${libdir}/enigma2/python/*/*.debug \
	${libdir}/enigma2/python/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*.debug \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*/*.debug \
	"

FILES_${PN}-src += "\
	${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "", " \
	${libdir}/enigma2/python/*.py \
	${libdir}/enigma2/python/*/*.py \
	${libdir}/enigma2/python/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*/*.py", d)} \
	"

FILES_${PN}-po += "\
	${libdir}/enigma2/python/*.po \
	${libdir}/enigma2/python/*/*.po \
	${libdir}/enigma2/python/*/*/*.po \
	${libdir}/enigma2/python/*/*/*/*.po \
	${libdir}/enigma2/python/*/*/*/*/*.po \
	${libdir}/enigma2/python/*/*/*/*/*/*.po \
	${libdir}/enigma2/python/*/*/*/*/*/*/*.po \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*.po \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*.po \
	${libdir}/enigma2/python/*/*/*/*/*/*/*/*/*/*.po \
	"

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends="enigma2")
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\/.*\.po$', 'enigma2-plugin-%s-po', '%s (translations)', recursive=True, match_path=True, prepend=True)
}
