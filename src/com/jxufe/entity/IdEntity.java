package com.jxufe.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * ͳһ����id��entity����.
 * 
 * ����ͳһ����id���������ơ��������͡�����ӳ�估���ɲ���.
 * ���������getId()�����ض���id������ӳ������ɲ���.
 * 
 */
//JPA ����ı�ʶ
@MappedSuperclass
public abstract class IdEntity implements Serializable {
	/** ����  */
	private static final long serialVersionUID = 8430941165882152228L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	protected int id = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
