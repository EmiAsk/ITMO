#!/usr/bin/bash
chmod -R 700 lab0 2>/dev/null
rm -R lab0 2>/dev/null
mkdir lab0
cd lab0

shopt -s globstar

# ========= 1 ==========
# Creating files
touch beedrill3 lotad0 minccino6

# Creating directories containing other dirs and files
mkdir deerling6 kricketune7 scraggy4


cd deerling6
touch altaria vullaby
mkdir kadabra
cd ..

cd kricketune7
touch yanmega magnezone herdier
mkdir gorebyss armaldo sunkern
cd ..


cd scraggy4
touch swanna tentacool seismitoad
mkdir hitmontop butterfree
cd ..


cat >> beedrill3 << EOF
Ходы Air Cutter Bug Bite Double-Edge Drill Run Electroweb
Endeavor Fury Cutter Giga Drain Knock Off Ominous Wind Roost Silver
Wind Sleep Talk Snore String Shot Swift Tailwind
EOF

cd deerling6

cat >> altaria << EOF
Тип диеты
Herbivore
EOF

cat >> vullaby << EOF
Способности  Dark Art Mach Speed Big Pecks
Overcoat
EOF

cd ../kricketune7

cat >> yanmega << EOF
Способности  Quick Attack Double Team Sonicboom
Detect Supersonic Uproar Pursuit Ancientpower Feint Slash Screech
U-Turn Air Slash Bug Buzz
EOF

cat >> magnezone << EOF
satk=3 sdef=9
spd=6
EOF

cat >> herdier << EOF
Способности  Odor Sleuth Bite Helping Hand Take Down
Work Up Crunch Roar Retaliate Reversal Last Resort Giga
Impact
EOF

cd ../scraggy4

cat >> swanna << EOF
Возможности  Overland=4 Surface=8 Sky=8 Underwater=6
Jump=3 Power=2 Intelligence=4 Fountain=0 Guster=0
EOF

cat >> tentacool << EOF
Ходы
Bind Brine Dive Double-Edge Giga Drain Icy Wind Knock Off Magic Coat
Role Play Sleep Talk Snore
EOF

cat >> seismitoad << EOF
Тип диеты  Herbivore
EOF

cd ..

cat >> lotad0 << EOF
Живет  Freshwater
EOF

cat >> minccino6 << EOF
Живет Forest Grassland
Urban
EOF

# ============ 2 =============
chmod 644 beedrill3
chmod 736 deerling6
cd deerling6
chmod 404 altaria
chmod g=rwx,u=g-r,o=g-w kadabra
chmod 622 vullaby
cd ..

chmod 355 kricketune7
cd kricketune7
chmod ug=r,o= yanmega
chmod 736 gorebyss
chmod 577 armaldo
chmod ug=r,o= magnezone
chmod 062 herdier
chmod 736 sunkern
cd ..

chmod 666 lotad0
chmod 640 minccino6

chmod ug=wx,o=rx scraggy4
cd scraggy4
chmod u=r,go= swanna
chmod 620 tentacool
chmod 335 hitmontop
chmod 737 butterfree
chmod 004 seismitoad
cd ..

# ============== 3 ==============
ln minccino6 scraggy4/seismitoadminccino
ln -s scraggy4 Copy_85

chmod u+r scraggy4/seismitoad
cat scraggy4/tentacool scraggy4/seismitoad > minccino6_98
chmod u-r scraggy4/seismitoad
cat beedrill3 > kricketune7/herdierbeedrill
cp beedrill3 kricketune7/gorebyss

# chmod u-r scraggy4/butterfree
# chmod u+r scraggy4
# cp -R scraggy4 scraggy4/butterfree 2>/dev/null
# chmod u+r scraggy4/butterfree
# chmod u-r scraggy4

cd scraggy4
chmod u+r . seismitoad hitmontop
cd ..

mkdir tmp
chmod 700 tmp
cp -R scraggy4 tmp
mv tmp/scraggy4 scraggy4/butterfree
rmdir tmp

cd scraggy4
chmod u-r . seismitoad hitmontop
cd ..

ln -s lotad0 kricketune7/magnezonelotad

# ls -lR .
# ========== 4 ===============
errors="/tmp/s367064"
touch $errors
chmod 700 $errors

echo -e "\n\n======== 4.1 =========\n" 
wc -l scraggy4/swanna scraggy4/tentacool | sort -nrk1

echo -e "\n\n======== 4.2 =========\n"
ls -Rl  2>/dev/null | sort -fk9,9 | tail -n3

echo -e "\n\n======== 4.3 =========\n"
# grep's flag -i used to ignore case
cat kricketune7/yanmega kricketune7/magnezone kricketune7/herdier scraggy4/swanna | grep -vi "te"

echo -e "\n\n======== 4.4 =========\n"
# ls's -S flag used to sort by size, -r for reversed order
ls -lS scraggy4

echo -e "\n\n======== 4.5 =========\n"
# -d ls flag is used to display dirs as plain files
#ls -ldt * */* | head -n2
ls -ldt * */* | head -n2

echo -e "\n\n======== 4.6 =========\n"
cat **/*6 2>&1 | sort -f  

# ============== 5 ================
rm -f lotad0
rm -f scraggy4/swanna
rm -f kricketune7/magnezonelot*
rm -f scraggy4/seismitoadmincci*
chmod -R 700 scraggy4
rm -Rf scraggy4
chmod -R 700 kricketune7/gorebyss
rm -Rf kricketune7/gorebyss
