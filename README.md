# War of Insects Simulator

The program was developed to present the simulation of war between four insect species:

* **ants** - represented by red points
* **wasps** - represented by blue points
* **dytiscidaes** - represented by white points
* **thanasimuses** - represented by green points

The program was developed in Java. It is object-oriented. I invite you to get acquainted with the [documentation](https://drive.google.com/open?id=1qWJk8jouMnm98tGwBHFwxKlTG03OeNDQ) (written in Polish language).

## Species and their enemies

* ants attack wasps
* wasps attack dytiscidaes
* dytiscidaes attack thanasimuses
* thanasimuses attack ants

The simulation ends in two cases:

* there are only insects of one specie in the environment
* there are insects of two species in the environment that don't attack each other

## Eusocialities and their roles

Every insect specie can perform one of the four roles:

* queens - they need to be inseminated by drones to born new soldiers
* drones - they need to find the queen, inseminate her and regenerate
* soldiers - they need to kill the enemy insect
* workers - they need to cure the injured (alive) family insect

## Types of insects

Using inheritance, the 16 types of insects was implemented:

* queen ant insect
* drone ant insect
* dytiscidae ant insect
* thanasimus ant insect
* queen wasp insect
* drone wasp insect
* dytiscidae wasp insect
* thanasimus wasp insect
* queen dytiscidae insect
* drone dytiscidae insect
* dytiscidae dytiscidae insect
* thanasimus dytiscidae insect
* queen thanasimus insect
* drone thanasimus insect
* dytiscidae thanasimus insect
* thanasimus thanasimus insect

## Prerequisites

* Linux or macOS
* at least Java 8

## Building the simulation

```
javac -d bin -sourcepath src src/main/StartSimulation.java
```

## Running the simulation

```
java -classpath bin main.StartSimulation
```

After running the program you may change values of attack (soldiers), cure (workers) and regeretarion time (drones) ane see how it affects the simulation.
