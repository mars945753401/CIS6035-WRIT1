import request from '@/utils/request'

// Search equipments
export function listEquip(query) {
  return request({
    url: '/resource/equip/list',
    method: 'get',
    params: query
  })
}

// Search equipments (without pagination)
export function listEquipWithoutPagination(query) {
  return request({
    url: '/resource/equip/listEquipWithoutPagination',
    method: 'get',
    params: query
  })
}

// Search equipment by ID
export function getEquip(equipId) {
  return request({
    url: '/resource/equip/' + equipId,
    method: 'get'
  })
}

// Add equipment
export function addEquip(data) {
  return request({
    url: '/resource/equip',
    method: 'post',
    data: data
  })
}

// Edit equipment
export function updateEquip(data) {
  return request({
    url: '/resource/equip',
    method: 'put',
    data: data
  })
}

// Delete equipment by ID
export function delEquip(equipId) {
  return request({
    url: '/resource/equip/' + equipId,
    method: 'delete'
  })
}
