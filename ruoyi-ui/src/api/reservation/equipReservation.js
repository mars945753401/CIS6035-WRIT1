import request from '@/utils/request'

// Search equipment reservations
export function listEquipReservation(query) {
  return request({
    url: '/reservation/equip/list',
    method: 'get',
    params: query
  })
}

// Search equipment reservation by ID
export function getEquipReservation(equipReservationId) {
  return request({
    url: '/reservation/equip/' + equipReservationId,
    method: 'get'
  })
}

// Add equipment reservation
export function addEquipReservation(data) {
  return request({
    url: '/reservation/equip',
    method: 'post',
    data: data
  })
}

// Edit equipment reservation
export function updateEquipReservation(data) {
  return request({
    url: '/reservation/equip',
    method: 'put',
    data: data
  })
}

// Delete equipment reservation by ID
export function delEquipReservation(equipReservationId) {
  return request({
    url: '/reservation/equip/' + equipReservationId,
    method: 'delete'
  })
}
