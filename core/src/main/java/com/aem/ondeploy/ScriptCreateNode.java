package com.aem.ondeploy;

import com.adobe.acs.commons.ondeploy.scripts.OnDeployScript;
import com.adobe.acs.commons.ondeploy.scripts.OnDeployScriptBase;

import javax.jcr.Node;


/**
 * This Script tries to get node in the absolute path of specific type, if not present creates a new node and adds property
 */
public class ScriptCreateNode extends OnDeployScriptBase  implements OnDeployScript {

    @Override
    protected void execute() throws Exception {
        Node nodeUpdate = getOrCreateNode("/content/we-retail/us/en/onDeployPage/jcr:content","cq:Page","cq:PageContent");
        nodeUpdate.setProperty("sling:resourceType","weretail/components/structure/page");
    }
}
