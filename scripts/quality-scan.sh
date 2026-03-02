#!/usr/bin/env bash
set -euo pipefail

./gradlew --no-daemon clean check

python3 - <<'PY'
import json
import subprocess
from pathlib import Path

root = Path('.')
errors = []
for path in root.rglob('*.json'):
    if any(part in {'.gradle', 'build', '.git', '.gradle-bin'} for part in path.parts):
        continue
    try:
        json.loads(path.read_text(encoding='utf-8'))
    except Exception as exc:
        errors.append((str(path), str(exc)))

if errors:
    for p, e in errors:
        print(f'JSON parse error: {p}: {e}')
    raise SystemExit(1)

binary_exts = {'.png', '.jpg', '.jpeg', '.gif', '.webp', '.bmp', '.ico', '.jar', '.class'}
allowed_binaries = {
    'fabric/src/main/resources/assets/spearsmod/textures/item/copper_spear_je1_be1.png',
    'fabric/src/main/resources/assets/spearsmod/textures/item/diamond_spear_je1_be1.png',
    'fabric/src/main/resources/assets/spearsmod/textures/item/golden_spear_je1_be1.png',
    'fabric/src/main/resources/assets/spearsmod/textures/item/iron_spear_je1_be1.png',
    'fabric/src/main/resources/assets/spearsmod/textures/item/netherite_spear_je1_be1.png',
    'fabric/src/main/resources/assets/spearsmod/textures/item/stone_spear_je1_be1.png',
    'fabric/src/main/resources/assets/spearsmod/textures/item/wooden_spear_je1_be1.png',
    'forge/src/main/resources/assets/spearsmod/textures/item/copper_spear_je1_be1.png',
    'forge/src/main/resources/assets/spearsmod/textures/item/diamond_spear_je1_be1.png',
    'forge/src/main/resources/assets/spearsmod/textures/item/golden_spear_je1_be1.png',
    'forge/src/main/resources/assets/spearsmod/textures/item/iron_spear_je1_be1.png',
    'forge/src/main/resources/assets/spearsmod/textures/item/netherite_spear_je1_be1.png',
    'forge/src/main/resources/assets/spearsmod/textures/item/stone_spear_je1_be1.png',
    'forge/src/main/resources/assets/spearsmod/textures/item/wooden_spear_je1_be1.png',
    'neoforge/src/main/resources/assets/spearsmod/textures/item/copper_spear_je1_be1.png',
    'neoforge/src/main/resources/assets/spearsmod/textures/item/diamond_spear_je1_be1.png',
    'neoforge/src/main/resources/assets/spearsmod/textures/item/golden_spear_je1_be1.png',
    'neoforge/src/main/resources/assets/spearsmod/textures/item/iron_spear_je1_be1.png',
    'neoforge/src/main/resources/assets/spearsmod/textures/item/netherite_spear_je1_be1.png',
    'neoforge/src/main/resources/assets/spearsmod/textures/item/stone_spear_je1_be1.png',
    'neoforge/src/main/resources/assets/spearsmod/textures/item/wooden_spear_je1_be1.png',
    'quilt/src/main/resources/assets/spearsmod/textures/item/copper_spear_je1_be1.png',
    'quilt/src/main/resources/assets/spearsmod/textures/item/diamond_spear_je1_be1.png',
    'quilt/src/main/resources/assets/spearsmod/textures/item/golden_spear_je1_be1.png',
    'quilt/src/main/resources/assets/spearsmod/textures/item/iron_spear_je1_be1.png',
    'quilt/src/main/resources/assets/spearsmod/textures/item/netherite_spear_je1_be1.png',
    'quilt/src/main/resources/assets/spearsmod/textures/item/stone_spear_je1_be1.png',
    'quilt/src/main/resources/assets/spearsmod/textures/item/wooden_spear_je1_be1.png',
}
tracked = subprocess.check_output(['git', 'ls-files'], text=True).splitlines()
binaries = [
    p for p in tracked
    if Path(p).suffix.lower() in binary_exts and p not in allowed_binaries
]
if binaries:
    print('Binary files are not allowed in this repository policy unless explicitly allowlisted. Remove these tracked files:')
    for p in binaries:
        print(f' - {p}')
    raise SystemExit(1)

print('JSON validation passed.')
print('Binary policy check passed (all tracked binary assets are allowlisted).')
PY
