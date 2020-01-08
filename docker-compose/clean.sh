#!/usr/bin/env bash
echo "Clean local docker MySQL..."

mysql --protocol=tcp -P 13306 -u root -proot -e "DROP DATABASE IF EXISTS eshop;CREATE DATABASE IF NOT EXISTS eshop DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_unicode_ci;"
