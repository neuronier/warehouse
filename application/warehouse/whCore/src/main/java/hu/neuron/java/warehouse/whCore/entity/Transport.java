package hu.neuron.java.warehouse.whCore.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Transport")
public class Transport extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A feladó raktár id-ja
	 */
	private long fromWarehouseId;

	/**
	 * Az átvevő raktár id-ja
	 */
	private long toWarehouseId;

	/**
	 * A feladó raktár neve
	 */
	private String fromWarehouseName;

	/**
	 * A feladó raktár zip kódja
	 */
	private int fromWarehouseZipCode;
	
	/**
	 * A feladó raktár városa
	 */
	private int fromWarehouseCity;
	
	/**
	 * A feladó raktár utcája
	 */
	private int fromWarehouseAddress;
	
	/**
	 * A feladó raktár házszáma
	 */
	private int fromWarehouseAddressNumber;

	/**
	 * A feladó raktáros neve
	 */
	private String fromWarehouseUserName;

	/**
	 * A feladó raktáros telefonszáma
	 */
	private Long fromWarehouseUserPhone;

	/**
	 * A feladó raktáros e-mail címe
	 */
	private String fromWarehouseUserEmail;

	/**
	 * Az átvevő raktár neve
	 */
	private String toWarehouseName;
	
	/**
	 * Az átvevő raktár zip kódja
	 */
	private int toWarehouseZipCode;
	
	/**
	 * Az átvevő raktár városa
	 */
	private int toWarehouseCity;
	
	/**
	 * Az átvevő raktár utcája
	 */
	private int toWarehouseAddress;
	
	/**
	 * Az átvevő raktár házszáma
	 */
	private int toWarehouseAddressNumber;

	/**
	 * Az átvevő raktáros neve
	 */
	private String toWarehouseUserName;

	/**
	 * Az feladó raktáros telefonszáma
	 */
	private Long toWarehouseUserPhone;

	/**
	 * Az átvevő raktáros e-mail címe
	 */
	private String toWarehouseUserEmail;

	/**
	 * Az eszköz típus neve
	 */
	private String itemName;

	/**
	 * Az eszköz típus cikkszáma
	 */
	private int articleNumber;

	/**
	 * Az eszköz darabszáma
	 */
	private int piece;
	

//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "warehouse_warehouse_sw")
//	private Collection<Warehouse> warehouses;

	public long getFromWarehouseId() {
		return fromWarehouseId;
	}

	public void setFromWarehouseId(long fromWarehouseId) {
		this.fromWarehouseId = fromWarehouseId;
	}

	public long getToWarehouseId() {
		return toWarehouseId;
	}

	public void setToWarehouseId(long toWarehouseId) {
		this.toWarehouseId = toWarehouseId;
	}

	public String getFromWarehouseName() {
		return fromWarehouseName;
	}

	public void setFromWarehouseName(String fromWarehouseName) {
		this.fromWarehouseName = fromWarehouseName;
	}

	public int getFromWarehouseZipCode() {
		return fromWarehouseZipCode;
	}

	public void setFromWarehouseZipCode(int fromWarehouseZipCode) {
		this.fromWarehouseZipCode = fromWarehouseZipCode;
	}

	public int getFromWarehouseCity() {
		return fromWarehouseCity;
	}

	public void setFromWarehouseCity(int fromWarehouseCity) {
		this.fromWarehouseCity = fromWarehouseCity;
	}

	public int getFromWarehouseAddress() {
		return fromWarehouseAddress;
	}

	public void setFromWarehouseAddress(int fromWarehouseAddress) {
		this.fromWarehouseAddress = fromWarehouseAddress;
	}

	public int getFromWarehouseAddressNumber() {
		return fromWarehouseAddressNumber;
	}

	public void setFromWarehouseAddressNumber(int fromWarehouseAddressNumber) {
		this.fromWarehouseAddressNumber = fromWarehouseAddressNumber;
	}

	public String getFromWarehouseUserName() {
		return fromWarehouseUserName;
	}

	public void setFromWarehouseUserName(String fromWarehouseUserName) {
		this.fromWarehouseUserName = fromWarehouseUserName;
	}

	public Long getFromWarehouseUserPhone() {
		return fromWarehouseUserPhone;
	}

	public void setFromWarehouseUserPhone(Long fromWarehouseUserPhone) {
		this.fromWarehouseUserPhone = fromWarehouseUserPhone;
	}

	public String getFromWarehouseUserEmail() {
		return fromWarehouseUserEmail;
	}

	public void setFromWarehouseUserEmail(String fromWarehouseUserEmail) {
		this.fromWarehouseUserEmail = fromWarehouseUserEmail;
	}

	public String getToWarehouseName() {
		return toWarehouseName;
	}

	public void setToWarehouseName(String toWarehouseName) {
		this.toWarehouseName = toWarehouseName;
	}

	public int getToWarehouseZipCode() {
		return toWarehouseZipCode;
	}

	public void setToWarehouseZipCode(int toWarehouseZipCode) {
		this.toWarehouseZipCode = toWarehouseZipCode;
	}

	public int getToWarehouseCity() {
		return toWarehouseCity;
	}

	public void setToWarehouseCity(int toWarehouseCity) {
		this.toWarehouseCity = toWarehouseCity;
	}

	public int getToWarehouseAddress() {
		return toWarehouseAddress;
	}

	public void setToWarehouseAddress(int toWarehouseAddress) {
		this.toWarehouseAddress = toWarehouseAddress;
	}

	public int getToWarehouseAddressNumber() {
		return toWarehouseAddressNumber;
	}

	public void setToWarehouseAddressNumber(int toWarehouseAddressNumber) {
		this.toWarehouseAddressNumber = toWarehouseAddressNumber;
	}

	public String getToWarehouseUserName() {
		return toWarehouseUserName;
	}

	public void setToWarehouseUserName(String toWarehouseUserName) {
		this.toWarehouseUserName = toWarehouseUserName;
	}

	public Long getToWarehouseUserPhone() {
		return toWarehouseUserPhone;
	}

	public void setToWarehouseUserPhone(Long toWarehouseUserPhone) {
		this.toWarehouseUserPhone = toWarehouseUserPhone;
	}

	public String getToWarehouseUserEmail() {
		return toWarehouseUserEmail;
	}

	public void setToWarehouseUserEmail(String toWarehouseUserEmail) {
		this.toWarehouseUserEmail = toWarehouseUserEmail;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}

	
}
