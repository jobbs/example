/**
 * copyright 2017 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename OpenShiftURIConstant.java
 *
 * @author x
 * @lastmodifier x
 * @created 2017. 05. 01.
 * @lastmodified 2017. 08. 01.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 08. 01.     x         v1.0             최초생성
 *
 */
package ncis.cmn.config;


public class OpenShiftURIConstant {
	public OpenShiftURIConstant(){}

		public static final String OPENSHIFT_URI_BASE_CONTEXT = "/autoscale";

		public static final String OPENSHIFT_URI_PROJECTREQUESTS = "/projectrequests";
		public static final String OPENSHIFT_URI_NAMESPACES = "/namespaces";
		public static final String OPENSHIFT_URI_NAMESPACES_PARAM = "/namespaces/{namespace}";
		public static final String OPENSHIFT_URI_NAMESPACES_LIMITRANGES = "/namespaces/{namespace}/limitranges";
		public static final String OPENSHIFT_URI_NAMESPACES_RESOURCEQUOTAS = "/namespaces/{namespace}/resourcequotas";
		public static final String OPENSHIFT_URI_NAMESPACES_LIMITRANGES_PARAM = "/namespaces/{namespace}/limitranges/{name}";
		public static final String OPENSHIFT_URI_NAMESPACES_RESOURCEQUOTAS_PARAM = "/namespaces/{namespace}/resourcequotas/{name}";
		public static final String OPENSHIFT_URI_PERSISTENTVOLUMES = "/persistentvolumes";
		public static final String OPENSHIFT_URI_SECRETS = "/namespaces/{namespace}/secrets";
		public static final String OPENSHIFT_URI_SERVICES = "/namespaces/{namespace}/services";
		public static final String OPENSHIFT_URI_SERVICES_PARAM = "/namespaces/{namespace}/services/{name}";
		public static final String OPENSHIFT_URI_ROUTES = "/namespaces/{namespace}/routes";
		public static final String OPENSHIFT_URI_ROUTES_PARAM = "/namespaces/{namespace}/routes/{name}";
		public static final String OPENSHIFT_URI_IMAGESTREAMS = "/namespaces/{namespace}/imagestreams";
		public static final String OPENSHIFT_URI_IMAGESTREAMS_PARAM = "/namespaces/{namespace}/imagestreams/{name}";
		public static final String OPENSHIFT_URI_BUILDCONFIGS = "/namespaces/{namespace}/buildconfigs";
		public static final String OPENSHIFT_URI_BUILDCONFIGS_PARAM = "/namespaces/{namespace}/buildconfigs/{name}";
		public static final String OPENSHIFT_URI_DEPLOYMENTCONFIGS = "/namespaces/{namespace}/deploymentconfigs";
		public static final String OPENSHIFT_URI_DEPLOYMENTCONFIGS_PARAM = "/namespaces/{namespace}/deploymentconfigs/{name}";
		public static final String OPENSHIFT_URI_SERVICEACCOUNTS = "/namespaces/{namespace}/serviceaccounts";
		public static final String OPENSHIFT_URI_ROLLBINDINGS = "/namespaces/{namespace}/rolebindings";
		public static final String OPENSHIFT_URI_ADDOSNODES = "/SeoaApi/addOSNodes";
		public static final String OPENSHIFT_URI_NODES_PARAM = "/nodes/{name}";
		public static final String OPENSHIFT_URI_INSTANTIATE_PARAM = "/namespaces/{namespace}/buildconfigs/{name}/instantiate";
		public static final String OPENSHIFT_URI_PERSISTENTVOLUMECLAIMS  = "/namespaces/{namespace}/persistentvolumeclaims";
		public static final String OPENSHIFT_URI_DEPLOYCONFIGS  = "/namespaces/{namespace}/deploymentconfigs";
		public static final String OPENSHIFT_URI_DEPLOYMENTCONFIGS_SCALE  = "/namespaces/{namespace}/deploymentconfigs/{name}/scale";
		public static final String OPENSHIFT_URI_PODS  = "/namespaces/{namespace}/pods";
		public static final String OPENSHIFT_URI_PODS_PARAM  = "/namespaces/{namespace}/pods/{name}";
		public static final String OPENSHIFT_URI_DETAIL_DEPLOYCONFIGS = "/namespaces/{namespace}/deploymentconfigs/{name}";
		public static final String OPENSHIFT_URI_BUILDS_PARAM = "/namespaces/{namespace}/builds/{name}";
		public static final String OPENSHIFT_URI_REPLICATIONCONTROLLERS_PARAM = "/namespaces/{namespace}/replicationcontrollers/{name}";
		public static final String OPENSHIFT_URI_HORIZONTALPODAUTOSCALERS = "/namespaces/{namespace}/horizontalpodautoscalers";
		public static final String OPENSHIFT_URI_HORIZONTALPODAUTOSCALERS_PARAM = "/namespaces/{namespace}/horizontalpodautoscalers/{name}";
		public static final String OPENSHIFT_URI_PERSISTENTVOLUMECLAIMS_PARAM  = "/namespaces/{namespace}/persistentvolumeclaims/{name}";
		public static final String OPENSHIFT_URI_ROLLBINDINGS_PARAM = "/namespaces/{namespace}/rolebindings/{name}";

		public static final String OPENSHIFT_STR_NAMESPACES = "{namespace}";
		public static final String OPENSHIFT_STR_NAME = "{name}";
}
