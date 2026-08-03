# Culinary Dragons

A polished food-and-drink expansion for Minecraft 1.18.2 Forge modpacks such as Guns, Magic and Dragons.

## v0.3.3 machine grounding update

- Added full-footprint base plates to all four machine models so the block below cannot show through the machine footprint.
- Added bottom-face culling to station geometry.
- Disabled ambient occlusion on station models to prevent dark seams and block-edge shading artifacts on stepped geometry.
- Retained directional placement, rotation, block loot tables, complete station textures, and the v0.3.2 item asset fix.

## Station workflow

- Juicer: fruit → juice
- Blender: fruit → smoothies
- Fermentation Barrel: juice/fruit → wines, ciders, and mead
- Cooking Pot: raw ingredients → prepared meals

## Requirements

- Minecraft Java Edition 1.18.2
- Minecraft Forge 40.2.0 or newer in the 40.x line
- Java 17

Forge-only. No third-party mod is required.

## Build

```bash
./gradlew clean build
```

The JAR is written to `build/libs/`.
