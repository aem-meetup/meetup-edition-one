package com.aem.ondeploy;

import com.adobe.acs.commons.ondeploy.scripts.OnDeployScript;
import com.adobe.acs.commons.ondeploy.scripts.OnDeployScriptBase;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * This Script removes existing property to content nodes of specific resourceType
 */
public class ScriptRemoveProperty extends OnDeployScriptBase  implements OnDeployScript {

    @Override
    protected void execute() throws Exception {

        ResourceResolver resolver = getResourceResolver();
        QueryBuilder queryBuilder = resolver.adaptTo(QueryBuilder.class);
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("path", "/content/we-retail/");
        queryMap.put("1_property", "sling:resourceType");
        queryMap.put("1_property.value", "weretail/components/content/heroimage");
        queryMap.put("p.limit", "-1");

        Query query = queryBuilder.createQuery(PredicateGroup.create(queryMap), resolver.adaptTo(Session.class));
        SearchResult res = query.getResult();
        List<Hit> hits = res.getHits();
        try {
            for (Hit hit : hits) {
                Resource resource = hit.getResource();
                ModifiableValueMap valueMap = resource.adaptTo(ModifiableValueMap.class);
                valueMap.remove("newTitle");
            }
        } catch (RepositoryException rEx) {
            logger.error("Error accesing repository" + rEx, rEx);

        }
    }
}


