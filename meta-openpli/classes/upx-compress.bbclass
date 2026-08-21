DEPENDS:append:class-target = " upx-native"

UPX_ARGS ?= "--best"

do_upx() {
    echo "UPX - Binary compression"
    find "${UNPACKDIR}/packages-split" -type f -executable | while read line
    do
	if echo "${line}" | grep -q '/\.debug/'
	then
	    echo "Skipping debug binary: ${line}"
	else
	    if `file -b "${line}" | grep -qe '^ELF 32-bit LSB.*executable'`
	    then
		if command -v upx > /dev/null
		then
		    echo "Let's try and compress: ${line}"
		    upx ${UPX_ARGS} "${line}" || true
		else
		    bbwarn "upx not in PATH, leaving ${line} uncompressed"
		fi
	    fi
	fi
    done
}
addtask upx before do_package_write_ipk after do_package_qa do_prepare_recipe_sysroot
