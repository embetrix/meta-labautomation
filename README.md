# meta-labautomation

Yocto layer for lab test automation.

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
