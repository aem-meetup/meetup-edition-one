package com.aem.ondeploy;

import com.adobe.acs.commons.ondeploy.OnDeployScriptProvider;
import com.adobe.acs.commons.ondeploy.scripts.OnDeployScript;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Service identifies code scripts to be executed upon deployment.
 */
@Component(immediate = true)
@Service
@Properties({
        @Property(name = "service.description", value = "Developer service that identifies code scripts to execute upon deployment")
})
public class OnDeployScriptProviderImpl implements OnDeployScriptProvider {
    @Override
    public List<OnDeployScript> getScripts() {
        return Arrays.asList(
                new ScriptCreateNode(),
                new ScriptNodeUpdate(),
                new ScriptUpdateProperty(),
                new ScriptRemoveProperty(),
                new ScriptSearchUpdateResourceType()
        );
    }
}