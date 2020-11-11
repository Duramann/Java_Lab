1.8.1 :
Commande :
-sh-4.2$  yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar district trees.csv MRLabJava/District
Résultat :
-sh-4.2$ hdfs dfs -cat MRLabJava/District/part-r-00000
11
12
13
14
15
16
17
18
19
20
3
4
5
6
7
8
9


1.8.2 :
Commande :
-sh-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar species trees.csv MRLabJava/Species
Résultat :
-sh-4.2$ hdfs dfs -cat MRLabJava/Species/part-r-00000
Acer
Aesculus
Ailanthus
Alnus
Araucaria
Broussonetia
Calocedrus
Catalpa
Cedrus
Celtis
Corylus
Davidia
Diospyros
Eucommia
Fagus
Fraxinus
Ginkgo
Gymnocladus
Juglans
Liriodendron
Maclura
Magnolia
Paulownia
Pinus
Platanus
Pterocarya
Quercus
Robinia
Sequoia
Sequoiadendron
Styphnolobium
Taxodium
Taxus
Tilia
Ulmus
Zelkova


1.8.3 :
Commande :
yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar number_species trees.csv MRLabJava/NSpecies
Résultat :
-sh-4.2$ hdfs dfs -cat MRLabJava/NSpecies/part-r-00000
Acer    3
Aesculus        3
Ailanthus       1
Alnus   1
Araucaria       1
Broussonetia    1
Calocedrus      1
Catalpa 1
Cedrus  4
Celtis  1
Corylus 3
Davidia 1
Diospyros       4
Eucommia        1
Fagus   8
Fraxinus        1
Ginkgo  5
Gymnocladus     1
Juglans 1
Liriodendron    2
Maclura 1
Magnolia        1
Paulownia       1
Pinus   5
Platanus        19
Pterocarya      3
Quercus 4
Robinia 1
Sequoia 1
Sequoiadendron  5
Styphnolobium   1
Taxodium        3
Taxus   2
Tilia   1
Ulmus   1
Zelkova 4



1.8.4 :
Commande :
-sh-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar max_height trees.csv MRLabJava/MaxHeight
Résultat :
-sh-4.2$ hdfs dfs -cat MRLabJava/MaxHeight/part-r-00000
Acer    16.0
Aesculus        30.0
Ailanthus       35.0
Alnus   16.0
Araucaria       9.0
Broussonetia    12.0
Calocedrus      20.0
Catalpa 15.0
Cedrus  30.0
Celtis  16.0
Corylus 20.0
Davidia 12.0
Diospyros       14.0
Eucommia        12.0
Fagus   30.0
Fraxinus        30.0
Ginkgo  33.0
Gymnocladus     10.0
Juglans 28.0
Liriodendron    35.0
Maclura 13.0
Magnolia        12.0
Paulownia       20.0
Pinus   30.0
Platanus        45.0
Pterocarya      30.0
Quercus 31.0
Robinia 11.0
Sequoia 30.0
Sequoiadendron  35.0
Styphnolobium   10.0
Taxodium        35.0
Taxus   13.0
Tilia   20.0
Ulmus   15.0
Zelkova 30.0



1.8.5:
Commande :
yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar sort_height trees.csv MRLabJava/SortedHeight
Résultat :
-sh-4.2$ hdfs dfs -cat MRLabJava/SortedHeight/part-r-00000
0.0
2.0
5.0
6.0
9.0
10.0
10.0
10.0
10.0
10.0
11.0
12.0
12.0
12.0
12.0
12.0
12.0
12.0
12.0
13.0
13.0
14.0
14.0
14.0
15.0
15.0
15.0
15.0
15.0
16.0
16.0
16.0
16.0
18.0
18.0
18.0
18.0
20.0
20.0
20.0
20.0
20.0
20.0
20.0
20.0
20.0
20.0
20.0
20.0
22.0
22.0
22.0
22.0
22.0
23.0
25.0
25.0
25.0
25.0
25.0
25.0
26.0
27.0
27.0
28.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
30.0
31.0
31.0
32.0
33.0
34.0
35.0
35.0
35.0
35.0
35.0
40.0
40.0
40.0
42.0
45.0


1.8.6 :
Commande :
yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar oldest trees.csv MRLabJava/Oldest
Résultat :
-sh-4.2$ hdfs dfs -cat MRLabJava/Oldest/part-r-00000
1       District : 5, Age : 1601
(Le job ne renvoie pas uniquement le District mais aussi l'age. On aurait pu renvoyer uniquement le District en modifiant le toString dans notre custom writable mais 
ce n'est surement pas ce qui etait attendu non plus.


1.8.7 :
On a pas reussi la deuxième phase de mapreduce car difficulté a obtenir l'information qui sort du premier mapreduce. (et manque de temps)