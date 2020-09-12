# Simulation of war between insects

The simulator was developed in order to visualize the war between four insect species:

* **ants** (red points),
* **wasps** (blue points),
* **dytiscidaes** (white points),
* **thanasimuses** (green points).

## Species and their enemies

* Ants attack wasps.
* Wasps attack dytiscidaes.
* Dytiscidaes attack thanasimuses.
* Thanasimuses attack ants.

## Completion of the simulation

* There are only insects of one species in the environment.
* There are only insects of two species that don't attack each other in the environment.

## Eusocialities and their roles

* **Soldiers** need to kill the enemy insect.
* **Workers** need to cure the injured (alive) insect from their family.
* **Drones** need to inseminate the queen and regenerate.
* **Queens** need to be inseminated by drones in order to born the new soldiers.

## Building the simulation

```
javac -d bin -sourcepath src src/main/StartSimulation.java
```

## Running the simulation

```
java -classpath bin main.StartSimulation
```

After running the programme you may change the values of parameters: **attack** (soldiers), **cure** (workers) and **regeneration time** (drones) and check how it affects the simulation.
