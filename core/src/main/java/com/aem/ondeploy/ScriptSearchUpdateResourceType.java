package com.aem.ondeploy;

import com.adobe.acs.commons.ondeploy.scripts.OnDeployScript;
import com.adobe.acs.commons.ondeploy.scripts.OnDeployScriptBase;


/**
 * This Script Searches and updates existing resource Type to new Resource Type under content
 *
 */
public class ScriptSearchUpdateResourceType  extends OnDeployScriptBase implements OnDeployScript {

    @Override
    protected void execute() throws Exception {
        searchAndUpdateResourceType("weretail/components/content/title","weretail/components/content/text");
    }

}
