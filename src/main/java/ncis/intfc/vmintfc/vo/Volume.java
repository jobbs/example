/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename Volume.java
 *
 * @author selim
 * @lastmodifier selim
 * @created 2017. 2. 1.
 * @lastmodified 2017. 2. 1.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2017. 2. 1.     selim         v1.0             최초생성
 *
 */
package ncis.intfc.vmintfc.vo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 가상 서버 볼륨  정보
 * @author ihjang
 *
 */
public class Volume
{
	private String id;					// 볼륨  ID
	private String name;				// 볼륨 명
	private String description;			// 설명
	private String storageId;			// 부모 스토리지
	private String capacity;			// 볼륨 총 용량
	private String state;				// 상태
	private String volumeInterface;		// 인터페이스
	private String format;				// 포맷유형
	private String sparse;				// 볼륨 할당 여부
	private String bootable;			// 부팅 가능 여부
	private String shareable;			// 공유 가능 여부
	private String wipeAfterDelete;		// 삭제 후 정리 여부
	private String propagateErrors;		// 볼륨 에러 전파여부
	private String storageType;			// 스토리지 유형
	private String created;			// 생성일자

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	/**
	 * @return the storageId
	 */
	public String getStorageId()
	{
		return storageId;
	}
	/**
	 * @param storageId the storageId to set
	 */
	public void setStorageId(String storageId)
	{
		this.storageId = storageId;
	}
	/**
	 * @return the capacity
	 */
	public String getCapacity()
	{
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(String capacity)
	{
		this.capacity = capacity;
	}
	/**
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state)
	{
		this.state = state;
	}
	/**
	 * @return the volumeInterface
	 */
	public String getVolumeInterface()
	{
		return volumeInterface;
	}
	/**
	 * @param volumeInterface the volumeInterface to set
	 */
	public void setVolumeInterface(String volumeInterface)
	{
		this.volumeInterface = volumeInterface;
	}
	/**
	 * @return the format
	 */
	public String getFormat()
	{
		return format;
	}
	/**
	 * @param format the format to set
	 */
	public void setFormat(String format)
	{
		this.format = format;
	}
	/**
	 * @return the sparse
	 */
	public String getSparse()
	{
		return sparse;
	}
	/**
	 * @param sparse the sparse to set
	 */
	public void setSparse(String sparse)
	{
		this.sparse = sparse;
	}
	/**
	 * @return the bootable
	 */
	public String getBootable()
	{
		return bootable;
	}
	/**
	 * @param bootable the bootable to set
	 */
	public void setBootable(String bootable)
	{
		this.bootable = bootable;
	}
	/**
	 * @return the shareable
	 */
	public String getShareable()
	{
		return shareable;
	}
	/**
	 * @param shareable the shareable to set
	 */
	public void setShareable(String shareable)
	{
		this.shareable = shareable;
	}
	/**
	 * @return the wipeAfterDelete
	 */
	public String getWipeAfterDelete()
	{
		return wipeAfterDelete;
	}
	/**
	 * @param wipeAfterDelete the wipeAfterDelete to set
	 */
	public void setWipeAfterDelete(String wipeAfterDelete)
	{
		this.wipeAfterDelete = wipeAfterDelete;
	}
	/**
	 * @return the propagateErrors
	 */
	public String getPropagateErrors()
	{
		return propagateErrors;
	}
	/**
	 * @param propagateErrors the propagateErrors to set
	 */
	public void setPropagateErrors(String propagateErrors)
	{
		this.propagateErrors = propagateErrors;
	}
	/**
	 * @return the storageType
	 */
	public String getStorageType()
	{
		return storageType;
	}
	/**
	 * @param storageType the storageType to set
	 */
	public void setStorageType(String storageType)
	{
		this.storageType = storageType;
	}

	/**
	 * @return the created
	 */
	public String getCreated()
	{
		return created;
	}
	/**
	 * @param createDate the created to set
	 */
	public void setCreated(String createDate)
	{
		this.created = createDate;
	}

	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}

}
