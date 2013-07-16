# environs

Attempts to return the value of a JVM System Property.
If the System Property lookup fails, attempts to return an Environment Variable of the same name.
If the Environment Variable lookup fails, throws "MissingEnvVarError".

## Usage

    (:require [environs.core :as environs])

    (environs/get-env "FOO")

## License


Copyright (c) 2013 by Jack Morrill. All rights reserved.

Distributed under the Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
