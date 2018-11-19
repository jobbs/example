/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename QueryParamVo.java
 *
 * @author 박봉춘
 * @lastmodifier 박봉춘
 * @created 2016. 10. 14.
 * @lastmodified 2016. 10. 14.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 14.     박봉춘         v1.0             최초생성
 *
 */
package ncis.cmn.entity.couch;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.google.gson.Gson;

/**
 * CouchDB 쿼리 파라미터
 *
 * @author Kim Hyeok
 */
public class QueryParamVo {

	private static final Gson gson = new Gson();

	// GET
	private Object key;
	private Object[] keys;
	private Object startkey;
	private Object startkey_docid;
	private Object endkey;
	private Object endkey_docid;
	private Integer limit;
	private String stale; // ok, update_after
	private Boolean descending;
	private Integer skip;
	private Boolean group;
	private Integer group_level;
	private Boolean reduce;
	private Boolean include_docs;
	private Boolean inclusive_end;
	private Boolean update_seq;

	// DELETE
	private Object rev;

	// CHANGE FEED
	private Long since;
	private String feed;

	// BULK_DOCS
	private Boolean all_or_nothing;

	/**
	 * @return the key
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Object key) {
		this.key = key;
	}

	/**
	 * @return the keys
	 */
	public Object[] getKeys() {
		return keys;
	}

	/**
	 * @param keys the keys to set
	 */
	public void setKeys(Object[] keys) {
		this.keys = keys;
	}

	/**
	 * @return the startkey
	 */
	public Object getStartkey() {
		return startkey;
	}

	/**
	 * @param startkey the startkey to set
	 */
	public void setStartkey(Object startkey) {
		this.startkey = startkey;
	}

	/**
	 * @return the startkey_docid
	 */
	public Object getStartkey_docid() {
		return startkey_docid;
	}

	/**
	 * @param startkey_docid the startkey_docid to set
	 */
	public void setStartkey_docid(Object startkey_docid) {
		this.startkey_docid = startkey_docid;
	}

	/**
	 * @return the endkey
	 */
	public Object getEndkey() {
		return endkey;
	}

	/**
	 * @param endkey the endkey to set
	 */
	public void setEndkey(Object endkey) {
		this.endkey = endkey;
	}

	/**
	 * @return the endkey_docid
	 */
	public Object getEndkey_docid() {
		return endkey_docid;
	}

	/**
	 * @param endkey_docid the endkey_docid to set
	 */
	public void setEndkey_docid(Object endkey_docid) {
		this.endkey_docid = endkey_docid;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @return the stale
	 */
	public String getStale() {
		return stale;
	}

	/**
	 * @param stale the stale to set
	 */
	public void setStale(String stale) {
		this.stale = stale;
	}

	/**
	 * @return the descending
	 */
	public Boolean getDescending() {
		return descending;
	}

	/**
	 * @param descending the descending to set
	 */
	public void setDescending(Boolean descending) {
		this.descending = descending;
	}

	/**
	 * @return the skip
	 */
	public Integer getSkip() {
		return skip;
	}

	/**
	 * @param skip the skip to set
	 */
	public void setSkip(Integer skip) {
		this.skip = skip;
	}

	/**
	 * @return the group
	 */
	public Boolean getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Boolean group) {
		this.group = group;
	}

	/**
	 * @return the group_level
	 */
	public Integer getGroup_level() {
		return group_level;
	}

	/**
	 * @param group_level the group_level to set
	 */
	public void setGroup_level(Integer group_level) {
		this.group_level = group_level;
	}

	/**
	 * @return the reduce
	 */
	public Boolean getReduce() {
		return reduce;
	}

	/**
	 * @param reduce the reduce to set
	 */
	public void setReduce(Boolean reduce) {
		this.reduce = reduce;
	}

	/**
	 * @return the include_docs
	 */
	public Boolean getInclude_docs() {
		return include_docs;
	}

	/**
	 * @param include_docs the include_docs to set
	 */
	public void setInclude_docs(Boolean include_docs) {
		this.include_docs = include_docs;
	}

	/**
	 * @return the inclusive_end
	 */
	public Boolean getInclusive_end() {
		return inclusive_end;
	}

	/**
	 * @param inclusive_end the inclusive_end to set
	 */
	public void setInclusive_end(Boolean inclusive_end) {
		this.inclusive_end = inclusive_end;
	}

	/**
	 * @return the update_seq
	 */
	public Boolean getUpdate_seq() {
		return update_seq;
	}

	/**
	 * @param update_seq the update_seq to set
	 */
	public void setUpdate_seq(Boolean update_seq) {
		this.update_seq = update_seq;
	}

	/**
	 * @return the rev
	 */
	public Object getRev() {
		return rev;
	}

	/**
	 * @param rev the rev to set
	 */
	public void setRev(Object rev) {
		this.rev = rev;
	}

	/**
	 * @return the since
	 */
	public Long getSince() {
		return since;
	}

	/**
	 * @param since the since to set
	 */
	public void setSince(Long since) {
		this.since = since;
	}

	/**
	 * @return the feed
	 */
	public String getFeed() {
		return feed;
	}




	/**
	 * @param feed the feed to set
	 */
	public void setFeed(String feed) {
		this.feed = feed;
	}

	/**
	 * @return the gson
	 */
	public static Gson getGson() {
		return gson;
	}

	/**
	 * @return the all_or_nothing
	 */
	public Boolean getAll_or_nothing() {
		return all_or_nothing;
	}

	/**
	 * @param all_or_nothing the all_or_nothing to set
	 */
	public void setAll_or_nothing(Boolean all_or_nothing) {
		this.all_or_nothing = all_or_nothing;
	}


	/**
	 * JSON 인코딩된 파라미터 맵을 생성한다.
	 * <p>
	 * - 1234 => 1234<br>
	 * - "1234" => %221234%22<br>
	 * - [1234,5678] => [1234,5678]<br>
	 * - ["1234","5678"] => [%221234%22,%225678%22]<br>
	 *
	 * @return {@code MultiValueMap<String, String>} 파라미터 맵
	 */
	public MultiValueMap<String, String> toEncodedParamMap() {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		/*
		 * GET
		 */
		if (key != null) {
			params.add("key", gson.toJson(key));
		}
		if (keys != null) {
			params.add("keys", gson.toJson(keys));
		}
		if (startkey != null) {
			params.add("startkey", gson.toJson(startkey));
		}
		if (startkey_docid != null) {
			params.add("startkey_docid", gson.toJson(startkey_docid));
		}
		if (endkey != null) {
			params.add("endkey", gson.toJson(endkey));
		}
		if (endkey_docid != null) {
			params.add("endkey_docid", gson.toJson(endkey_docid));
		}
		if (limit != null) {
			params.add("limit", gson.toJson(limit));
		}
		if (stale != null) {
			params.add("stale", gson.toJson(stale));
		}
		if (descending != null) {
			params.add("descending", gson.toJson(descending));
		}
		if (skip != null) {
			params.add("skip", gson.toJson(skip));
		}
		if (group != null) {
			params.add("group", gson.toJson(group));
		}
		if (group_level != null) {
			params.add("group_level", gson.toJson(group_level));
		}
		if (reduce != null) {
			params.add("reduce", gson.toJson(reduce));
		}
		if (include_docs != null) {
			params.add("include_docs", gson.toJson(include_docs));
		}
		if (inclusive_end != null) {
			params.add("inclusive_end", gson.toJson(inclusive_end));
		}
		if (update_seq != null) {
			params.add("update_seq", gson.toJson(update_seq));
		}

		/*
		 * DELETE, ATTACH
		 */

		if (rev != null) {

			// rev 파라미터의 경우 문자열로 처리하면 오류(500:Internal Server Error)가 발생한다.
			// - 정상 : ?rev=1-2384575934292
			// - 오류 : ?rev=%221-2384575934292%22
			params.add("rev", rev.toString());
		}

		/*
		 * CHANGE FEED
		 */
		if (feed != null) {
			params.add("feed", feed);
		}
		if (since != null) {
			params.add("since", since.toString());
		}

		/*
		 * BUKL_DOCS
		 */
		if (all_or_nothing != null) {
			params.add("all_or_nothing", gson.toJson(all_or_nothing));
		}

		return params;
	}
}
