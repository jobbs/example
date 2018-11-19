/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OpenShiftPathConstant.java
 *
 * @author asg
 * @lastmodifier asg
 * @created 2017. 05. 01.
 * @lastmodified 2017. 08. 01.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 08. 01.     asg         v1.0             최초생성
 *
 */
package ncis.cmn.config;



public class OpenShiftPathConstant {
	public OpenShiftPathConstant(){}

		public static final String OPENSHIFT_JSON_PATH_VOLUMES = "$.spec.template.spec.volumes";
		public static final String OPENSHIFT_JSON_PATH_SPEC = "$.spec.template.spec";
		public static final String OPENSHIFT_JSON_PATH_CONTAINERS = "$.spec.template.spec.containers";
		public static final String OPENSHIFT_JSON_PATH_CONTAINERS_ARRAY = "$.spec.template.spec.containers[*]";
		public static final String OPENSHIFT_JSON_PATH_VOLUMEMOUNTS_ARRAY = "$.spec.template.spec.containers[*].volumeMounts";
		public static final String OPENSHIFT_JSON_PATH_PODS_STATUS_ARRAY = "$.items[*].status";
		public static final String OPENSHIFT_JSON_PATH_PODS_LABEL = "$.items[*].metadata.labels";
		public static final String OPENSHIFT_JSON_PATH_DEPLOYCONF_STATUS = "$.status";
		public static final String OPENSHIFT_JSON_PATH_DEPLOYCONF_RESOURCES = "$.spec.template.spec.containers[*].resources";
		public static final String OPENSHIFT_JSON_PATH_DEPLOYCONF_STATUS_CONTIDIONS = "$.status.conditions[*]";
		public static final String OPENSHIFT_JSON_PATH_BUILD__STATUS = "$.status";
		public static final String OPENSHIFT_JSON_PATH_REPLICATION_STATUS = "$.metadata.annotations";
		public static final String OPENSHIFT_JSON_PATH_DEPLOYCONF_ENV = "$.spec.template.spec.containers[*].env[*]";
		public static final String OPENSHIFT_JSON_PATH_LATESTVERSION = "$.status['latestVersion']";
		public static final String OPENSHIFT_JSON_PATH_BUILD_SPEC = "$.spec";
		public static final String OPENSHIFT_JSON_PATH_BUILD_SOURCE = "$.spec.source";
		public static final String OPENSHIFT_JSON_PATH_BUILD_STRATEGY_FROM = "$.spec.strategy.sourceStrategy.from";
		public static final String OPENSHIFT_JSON_PATH_BUILD_STRATEGY = "$.spec.strategy.sourceStrategy";
		public static final String OPENSHIFT_JSON_PATH_AUTO_SCALR_SPEC = "$.spec";
		public static final String OPENSHIFT_JSON_PATH_AUTO_SCALR_ROOT = "$";
		public static final String OPENSHIFT_JSON_PATH_ROLEBINDS_SUBJECTS = "$.subjects";
		public static final String OPENSHIFT_JSON_PATH_ROLEBINDS_METADATA_RESOURCEVERSION = "$.metadata.resourceVersion";
		public static final String OPENSHIFT_JSON_PATH_BUILD_OUTPUT_TO_NAME = "$.spec.output.to.name";


}
