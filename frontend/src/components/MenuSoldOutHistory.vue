<template>
    <div>
        <Number
            label="HistoryId"
            v-model="value.historyId"
            :editMode="editMode"
        />
        <String
            label="ChangedBy"
            v-model="value.changedBy"
            :editMode="editMode"
        />
        <Boolean
            label="PreviousSoldOutStatus"
            v-model="value.previousSoldOutStatus"
            :editMode="editMode"
        />
        <Boolean
            label="NewSoldOutStatus"
            v-model="value.newSoldOutStatus"
            :editMode="editMode"
        />
        <Date
            label="ChangedAt"
            v-model="value.changedAt"
            :editMode="editMode"
        />
        <MenuId
            offline
            label="MenuId"
            v-model="value.menuId"
            :editMode="editMode"
            @change="change"
        />
        <SoldOutChangeType
            offline
            label="ChangeType"
            v-model="value.changeType"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'MenuSoldOutHistory',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "menuSoldOutHistories",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
