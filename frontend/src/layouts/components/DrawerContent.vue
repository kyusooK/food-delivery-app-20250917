<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '주문/배달 관리' }" />
        <VerticalNavLink
            :item="{
                title: '주문',
                to: '/orders',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '주문 상태 추적',
                to: '/orderStatusTrackings',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '주문 상세 정보',
                to: '/orderDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '배달 내역 리스트',
                to: '/deliveryHistoryLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '메뉴 관리' }" />
        <VerticalNavLink
            :item="{
                title: '메뉴',
                to: '/menus',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '메뉴 품절 이력',
                to: '/menuSoldOutHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '메뉴 품절 상태 조회',
                to: '/menuSoldOutStatuses',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '메뉴 품절 이력 목록',
                to: '/menuSoldOutHistoryLists',
            }"
        />
    </ul>
</template>
