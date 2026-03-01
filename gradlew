#!/usr/bin/env bash
set -euo pipefail

if [[ -d "$HOME/.local/share/mise/installs/java/21.0.2" ]]; then
  export JAVA_HOME="$HOME/.local/share/mise/installs/java/21.0.2"
  export PATH="$JAVA_HOME/bin:$PATH"
fi

GRADLE_VERSION="8.10.2"
DIST_DIR=".gradle-bin"
GRADLE_HOME="$DIST_DIR/gradle-$GRADLE_VERSION"

if [[ ! -x "$GRADLE_HOME/bin/gradle" ]]; then
  mkdir -p "$DIST_DIR"
  ARCHIVE="$DIST_DIR/gradle-$GRADLE_VERSION-bin.zip"
  if [[ ! -f "$ARCHIVE" ]]; then
    curl -fsSL "https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-bin.zip" -o "$ARCHIVE"
  fi
  unzip -q -o "$ARCHIVE" -d "$DIST_DIR"
fi

exec "$GRADLE_HOME/bin/gradle" "$@"
