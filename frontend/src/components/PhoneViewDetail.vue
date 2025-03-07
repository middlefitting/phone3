<template>

    <v-card outlined>
        <v-card-title>
            Phone # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PhoneId" v-model="item.phoneId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Imei" v-model="item.imei" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="LostStatus" v-model="item.lostStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ImeiLockStatus" v-model="item.imeiLockStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="LockStatus" v-model="item.lockStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PhoneChangeStatus" v-model="item.phoneChangeStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="LostPhoneId" v-model="item.lostPhoneId" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'PhoneViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/phones/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

