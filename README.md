# environs

Attempts to return the value of a JVM System Property.
If the System Property lookup fails, attempts to return an Environment Variable of the same name.
If the Environment Variable lookup fails, throws "MissingEnvVarError".

## Usage

In project.clj :dependencies

    [org.clojars.jackmorrill/environs "0.1.0"]

In your application ns macro

    (:require [environs.core :as environs])

Retrieve a System Property

    (environs/get-env "FOO")

