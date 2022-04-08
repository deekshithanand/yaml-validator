package com.dstyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.function.Function;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.parser.ParserException;


@Mojo(name = "k8s" ,defaultPhase = LifecyclePhase.CLEAN)
public class ValidatorMojo extends AbstractMojo {
    private Log log = getLog();

    private String folder = "k8s/deploy";

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        log.info("YO THE PLUGIN IS WORKING!");
        File file = new File(folder+"/sampleConfig.yaml");
        Yaml yaml = new Yaml();
        try {
           yaml.loadAll(new FileInputStream(file)).forEach(i -> {});
            
        } catch (FileNotFoundException e) {
            log.warn("CONFIG FILES NOT FOUND");
            throw new MojoExecutionException("K8s file not found");
        }
        //  catch (ParserException e){
        //     log.warn("Yaml content incorrect:");
        //     log.error(e.getMessage());
        //     throw new MojoExecutionException("YAML FILE INCORRECT");
        // }

    }
}
