#!/usr/bin/env bash
set -euo pipefail

LOADER="${1:-}"
if [[ -z "${LOADER}" ]]; then
  echo "Usage: $0 <fabric|forge|neoforge|quilt>"
  exit 1
fi

case "$LOADER" in
  fabric|forge|neoforge|quilt) ;;
  *)
    echo "Unsupported loader: $LOADER"
    exit 1
    ;;
esac

./gradlew :common:test ":${LOADER}:build"
