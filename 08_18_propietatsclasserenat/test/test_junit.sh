#! /bin/bash

# Script per executar les proves unitàries

current=$(dirname "$0")

# Check that $1 contains the name of the program under test
if [ -z "$1" ];
then
    echo "Ús: $0 NomDelProgramaATestejar.java NomDelTest"
    exit 1
fi

testname=$1

# Recompliant tests amb junit
error=0
tmpfile=$(mktemp)
cd $current
javac --source-path .. -d . $testname.java &>$tmpfile
if [[ "$(cat $tmpfile)" != "" ]]; then
    echo "El joc de proves no compila amb el teu codi"
    echo
    cat $tmpfile
    error=1
else
    # Executa tests
    java org.junit.platform.console.ConsoleLauncher -c $testname --disable-banner &>$tmpfile
    if [[ "$(grep '^Failures (' $tmpfile)" != "" ]]; then
        echo "No passa un o més tests"
        echo
        cat $tmpfile
        error=1
    else
        if [[ "$2" == "lib" ]]; then echo; cat $tmpfile; fi
    fi
fi
rm $tmpfile
cd ..
if [ "$error" -eq 1 ];
then
    exit 1
fi
