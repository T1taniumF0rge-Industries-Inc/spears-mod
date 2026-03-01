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
tracked = subprocess.check_output(['git', 'ls-files'], text=True).splitlines()
binaries = [p for p in tracked if Path(p).suffix.lower() in binary_exts]
if binaries:
    print('Binary files are not allowed in this repository policy. Remove these tracked files:')
    for p in binaries:
        print(f' - {p}')
    raise SystemExit(1)

print('JSON validation passed.')
print('Binary policy check passed (no tracked binary assets).')
PY
