
    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `application` 
       drop 
       foreign key `FKoa6p4s2oyy7tf80xwc4r04vh6`;

    alter table `application` 
       drop 
       foreign key `FKmbjdoxi3o93agxosoate4sxbt`;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `consumer` 
       drop 
       foreign key FK_6cyha9f1wpj0dpbxrrjddrqed;

    alter table `descriptor_duty` 
       drop 
       foreign key `FK57eqqlhihwvd53ykpmsiqlx2p`;

    alter table `descriptor_duty` 
       drop 
       foreign key `FKqitedkrksd2w8qyp1fp5eao9f`;

    alter table `employer` 
       drop 
       foreign key FK_na4dfobmeuxkwf6p75abmb2tr;

    alter table `job` 
       drop 
       foreign key `FKfqwyynnbcsq0htxho3vchpd2u`;

    alter table `job` 
       drop 
       foreign key `FK3rxjf8uh6fh2u990pe8i2at0e`;

    alter table `job_application` 
       drop 
       foreign key `FKfp2h8978o9hejrn5hbe2pwcyf`;

    alter table `job_application` 
       drop 
       foreign key `FK5tcniavarhbbxc7sl99x3au6o`;

    alter table `provider` 
       drop 
       foreign key FK_b1gwnjqm6ggy9yuiqm0o4rlmd;

    alter table `worker` 
       drop 
       foreign key FK_l5q1f33vs2drypmbdhpdgwfv3;

    drop table if exists `administrator`;

    drop table if exists `announcement`;

    drop table if exists `anonymous`;

    drop table if exists `application`;

    drop table if exists `authenticated`;

    drop table if exists `challenge`;

    drop table if exists `company_record`;

    drop table if exists `consumer`;

    drop table if exists `descriptor`;

    drop table if exists `descriptor_duty`;

    drop table if exists `duty`;

    drop table if exists `employer`;

    drop table if exists `investor_record`;

    drop table if exists `job`;

    drop table if exists `job_application`;

    drop table if exists `offer`;

    drop table if exists `provider`;

    drop table if exists `requests`;

    drop table if exists `user_account`;

    drop table if exists `worker`;

    drop table if exists `hibernate_sequence`;
