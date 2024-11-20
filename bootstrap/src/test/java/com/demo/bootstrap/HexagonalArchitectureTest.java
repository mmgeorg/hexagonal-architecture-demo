package com.demo.bootstrap;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.demo", importOptions = ImportOption.DoNotIncludeTests.class)
public class HexagonalArchitectureTest {


    private static final String BAR_PORTS = "BAR_PORTS";
    private static final String BAR_ADAPTERS = "BAR_ADAPTERS";
    private static final String BAR_DOMAIN_MODEL = "BAR_DOMAIN_MODEL";
    private static final String BAR_DOMAIN_SERVICES = "BAR_DOMAIN_SERVICES";

    @ArchTest
    public static final ArchRule barHexagonalArchitecture = layeredArchitecture()
            .consideringAllDependencies()
            .layer(BAR_PORTS).definedBy("com.demo.bar.port..")
            .layer(BAR_ADAPTERS).definedBy("com.demo.bar.adapter..")
            .layer(BAR_DOMAIN_MODEL).definedBy("com.demo.bar.domain.model..")
            .layer(BAR_DOMAIN_SERVICES).definedBy("com.demo.bar.domain.service..")

            .whereLayer(BAR_DOMAIN_SERVICES).mayNotBeAccessedByAnyLayer()
            .whereLayer(BAR_ADAPTERS).mayNotBeAccessedByAnyLayer()
            .whereLayer(BAR_PORTS).mayOnlyBeAccessedByLayers(BAR_ADAPTERS, BAR_DOMAIN_SERVICES)
            .whereLayer(BAR_DOMAIN_MODEL).mayOnlyBeAccessedByLayers(BAR_DOMAIN_SERVICES, BAR_PORTS, BAR_ADAPTERS)
            .because("Bar module must follow the Hexagonal architecture pattern.");

    @ArchTest
    public static final ArchRule asd = classes().that().areAnnotatedWith(Service.class)
            .should().haveSimpleNameEndingWith("Service");

}
