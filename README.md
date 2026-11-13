# meta-labautomation

**meta-labautomation** is a Yocto layer for building a Linux controller for embedded testing labs. It brings together tools to flash boards, control power, access serial consoles, work with test instruments and run automated tests.

It includes Robot Framework, CI agents, container services and MCP servers. Optional Labgrid integration adds shared device control and a web dashboard. Packages are grouped by purpose so you can choose what your lab needs.

<img src="img/labautomation.png" alt="Lab automation" width="400">

## Build

```sh
kas build kas/kas-labautomation.yml
```

## Run in Qemu

```sh
kas shell kas/kas-labautomation.yml \
    -c 'runqemu kvm serialstdio nographic snapshot'
```
