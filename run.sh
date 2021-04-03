#!/bin/bash

set -e
host="$1"
shift
cmd="$@"

until PGPASSWORD=$POSTGRES_PASSWORD psql -h "$host" -U "admin" -c '\q'; do
  >&2 echo "Postgres starts..."
  sleep 1
done

>&2 echo "Postgres is up"
exec cmd