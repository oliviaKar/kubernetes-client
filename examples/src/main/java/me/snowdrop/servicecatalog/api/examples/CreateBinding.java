/**
 * Copyright (C) 2018 Red Hat, inc.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **/
package me.snowdrop.servicecatalog.api.examples;

import me.snowdrop.servicecatalog.api.model.ServiceBinding;
import me.snowdrop.servicecatalog.api.client.ServiceCatalogClient;
import io.fabric8.kubernetes.client.KubernetesClient;


public class CreateBinding {

    public static void main(String[] args) {
        ServiceCatalogClient client = ClientFactory.newClient(args);
        System.out.println("Creating a service binding");
        ServiceBinding binding = client.serviceBindings().inNamespace("iocanel").createNew()
            .withNewMetadata()
            .withName("mybinding")
            .endMetadata()
            .withNewSpec()
            .withNewServiceInstanceRef("myservice")
            .withSecretName("mysercret")
            .endSpec()
            .done();
    }
}
