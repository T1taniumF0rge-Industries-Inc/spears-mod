# Spears Mod (MC 1.21.8 target scaffold)

Multi-loader scaffold with shared spear combat mechanics for:
- NeoForge (main)
- Forge
- Fabric
- Quilt

## What was improved (inspired by reference mods)
- Shared mechanics tuned to align better with observed reference behavior:
  - relative-speed based spear power model inspired by `Masuno-Spears-1.21.8-FABRIC`
  - lunge multipliers `1.3/1.6/2.0` and cooldown `80 ticks` inspired by `spears-test` NeoForge runtime
- Added data packs per loader:
  - spear recipes (wood/stone/iron/copper/gold/diamond/netherite)
  - recipe unlock advancements
  - enchantment tags (`tradeable`, `non_treasure`, `on_random_loot`) for lunge
- Kept spear models/items/lang/data synchronized under each loader’s own resources tree.

## Build
```bash
./scripts/build-artifacts.sh neoforge
./scripts/build-artifacts.sh forge
./scripts/build-artifacts.sh fabric
./scripts/build-artifacts.sh quilt
```

## Parity status
This repository is still not a verified 100% runtime parity port of vanilla 1.21.11 spear internals.
The current state is a stronger scaffold + resource/data parity pass with improved reference-aligned mechanics modeling.


## Quality checks
```bash
./scripts/quality-scan.sh
```
