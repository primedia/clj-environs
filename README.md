# environs

Attempts to return the value of a JVM System Property.
If the System Property lookup fails, attempts to return an Environment Variable of the same name.
If the Environment Variable lookup fails, throws "MissingEnvVarError".

## Usage

In project.clj :dependencies

    [com.rentpath/environs "1.0.1"]

In your application ns macro

    (:require [com.rentpath.environs.core :as environs])

Retrieve a System Property

    (Env "FOO")

Throws "MissingEnvVarError" if FOO is not an environment variable or JVM System Property.

    (Env "FOO" allow-nil)

Just return nil if FOO is not an environment variable or JVM System Property.


